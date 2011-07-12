/*
 ************************************************************************************
 * Copyright (C) 2001-2010 encuestame: system online surveys Copyright (C) 2009
 * encuestame Development Team.
 * Licensed under the Apache Software License version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to  in writing,  software  distributed
 * under the License is distributed  on  an  "AS IS"  BASIS,  WITHOUT  WARRANTIES  OR
 * CONDITIONS OF ANY KIND, either  express  or  implied.  See  the  License  for  the
 * specific language governing permissions and limitations under the License.
 ************************************************************************************
 */
package org.encuestame.persistence.domain.tweetpoll;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.encuestame.persistence.domain.security.SocialAccount;
import org.encuestame.persistence.domain.social.SocialProvider;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

/**
 * TweetPoll Status Save Tweet Id.
 * @author Picado, Juan juanATencuestame.org
 * @since Jul 19, 2010 1:37:15 AM
 */
@Entity
@Indexed(index="TweetPollSavedPublishedStatus")
@Table(name = "tweetPoll_save_published_status")
public class TweetPollSavedPublishedStatus {

    /** Id. **/
    private Long id;

    /** {@link SocialAccount}. **/
    private SocialAccount twitterAccount;

    /** {@link TweetPoll}. **/
    private TweetPoll tweetPoll;

    /** Tweet Content. **/
    private String tweetContent;

    /**. Tweet Id. **/
    private String tweetId;

    /** Api Type. **/
    private SocialProvider apiType;

    /** Status. **/
    private Status status;

    /** Description Status. **/
    private String descriptionStatus;

    /** Publication Date Tweet. This date is from twitter after publish. **/
    private Date publicationDateTweet;

    /**
     * @return the id
     */
    @Id
    @DocumentId
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "status_save_poll_id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the apiType
     */
    @Column(name="type")
    @Enumerated(EnumType.STRING)
    public SocialProvider getApiType() {
        return apiType;
    }

    /**
     * @param apiType the apiType to set
     */
    public void setApiType(SocialProvider apiType) {
        this.apiType = apiType;
    }

    /**
     * @return the tweetPoll
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    public TweetPoll getTweetPoll() {
        return tweetPoll;
    }

    /**
     * @param tweetPoll the tweetPoll to set
     */
    public void setTweetPoll(final TweetPoll tweetPoll) {
        this.tweetPoll = tweetPoll;
    }

    /**
     * @return the twitterAccount
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    public SocialAccount getTwitterAccount() {
        return twitterAccount;
    }

    /**
     * @param twitterAccount the twitterAccount to set
     */
    public void setTwitterAccount(SocialAccount twitterAccount) {
        this.twitterAccount = twitterAccount;
    }

    /**
     * @return the tweetId
     */
    @Column(name = "tweet_id", nullable = true)
    public String getTweetId() {
        return tweetId;
    }

    /**
     * @param tweetId
     *            the tweetId to set
     */
    public void setTweetId(final String tweetId) {
        this.tweetId = tweetId;
    }

    /**
     * @return the publicationDateTweet
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "publication_date_tweet", nullable = true)
    public Date getPublicationDateTweet() {
        return publicationDateTweet;
    }

    /**
     * @param publicationDateTweet
     *            the publicationDateTweet to set
     */
    public void setPublicationDateTweet(Date publicationDateTweet) {
        this.publicationDateTweet = publicationDateTweet;
    }

    /**
     * @return the status
     */
    @Column(name="status")
    @Enumerated(EnumType.ORDINAL)
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @return the descriptionStatus
     */
    @Column(name = "status_description", nullable = true)
    public String getDescriptionStatus() {
        return descriptionStatus;
    }

    /**
     * @param descriptionStatus the descriptionStatus to set
     */
    public void setDescriptionStatus(String descriptionStatus) {
        this.descriptionStatus = descriptionStatus;
    }

    /**
     * @return the tweetContent
     */
    @Field(index=Index.TOKENIZED, store=Store.NO)
    @Column(name = "tweet_content")
    public String getTweetContent() {
        return tweetContent;
    }

    /**
     * @param tweetContent the tweetContent to set
     */
    public void setTweetContent(final String tweetContent) {
        this.tweetContent = tweetContent;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TweetPollSavedPublishedStatus [id=" + id + ", socialAccount="
                + twitterAccount.toString() + ", tweetPoll=" + tweetPoll.toString()
                + ", tweetContent=" + tweetContent + ", tweetId=" + tweetId
                + ", apiType=" + apiType + ", status=" + status
                + ", descriptionStatus=" + descriptionStatus
                + ", publicationDateTweet=" + publicationDateTweet + "]";
    }
}
